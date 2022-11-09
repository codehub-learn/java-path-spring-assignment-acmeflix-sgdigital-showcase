package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Content;
import com.acmeflix.domain.CreditCard;
import com.acmeflix.domain.Profile;
import com.acmeflix.exception.ViewingRestrictionException;

public interface AccountService extends BaseService<Account, Long> {
	void addProfiles(Account account, Profile... profiles);

	void addCreditCard(Account account, CreditCard creditCard);

	Account getFullContent(Long id);

	void rate(final Profile profile, final Content content, final Double rate) throws ViewingRestrictionException;
}
