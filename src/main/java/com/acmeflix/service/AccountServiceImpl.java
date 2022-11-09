package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Content;
import com.acmeflix.domain.CreditCard;
import com.acmeflix.domain.Profile;
import com.acmeflix.domain.Rating;
import com.acmeflix.domain.RatingKey;
import com.acmeflix.exception.ViewingRestrictionException;
import com.acmeflix.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	private final AccountRepository accountRepository;

	@Override
	public JpaRepository<Account, Long> getRepository() {
		return accountRepository;
	}

	@Override
	public void addProfiles(final Account account, final Profile... profiles) {
		Arrays.stream(profiles).forEach(p -> {
			p.setAccount(account);
			account.getProfiles().add(p);
		});
	}

	@Override
	public void addCreditCard(final Account account, final CreditCard creditCard) {
		creditCard.setAccount(account);
		account.getCreditCards().add(creditCard);
	}

	@Override
	public Account getFullContent(final Long id) {
		return accountRepository.getFullContent(id);
	}

	@Override
	public void rate(final Profile profile, final Content content, final Double rate)
			throws ViewingRestrictionException {
		if (content.getViewingRestriction().getAge() > profile.getViewingRestriction().getAge()) {
			throw new ViewingRestrictionException(
					"According to your profile settings, you are not allowed to rate this content.");
		}

		var rating = Rating.builder().id(new RatingKey(profile.getId(), content.getId())).rate(rate).build();
		profile.getRatings().add(rating);
		content.getRatings().add(rating);
		update(profile.getAccount());

		logger.debug("Profile '{}' rated '{}' with {}.", profile.getName(), content.getTitle(), rate);
		logger.trace("Profile '{}' total ratings {}.", profile.getName(), profile.getRatings());
	}
}
