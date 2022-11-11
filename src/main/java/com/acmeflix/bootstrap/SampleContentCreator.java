package com.acmeflix.bootstrap;

import com.acmeflix.base.BaseComponent;
import com.acmeflix.domain.Account;
import com.acmeflix.domain.CastMember;
import com.acmeflix.domain.CreditCard;
import com.acmeflix.domain.Episode;
import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Person;
import com.acmeflix.domain.Rating;
import com.acmeflix.domain.Season;
import com.acmeflix.domain.TvShow;
import com.acmeflix.domain.enumeration.Genre;
import com.acmeflix.domain.enumeration.Language;
import com.acmeflix.domain.enumeration.Role;
import com.acmeflix.domain.enumeration.SubscriptionPlans;
import com.acmeflix.domain.enumeration.ViewingRestriction;
import com.acmeflix.service.AccountService;
import com.acmeflix.service.CastMemberService;
import com.acmeflix.service.MovieService;
import com.acmeflix.service.PersonService;
import com.acmeflix.service.SubscriptionPlanService;
import com.acmeflix.service.TvShowService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
//@Profile("generate-sample-data")
@AllArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final AccountService accountService;
	private final CastMemberService castMemberService;
	private final MovieService movieService;
	private final PersonService personService;
	private final SubscriptionPlanService subscriptionPlanService;
	private final TvShowService tvShowService;

	@Override
	public void run(final String... args) throws Exception {
		subscriptionPlanService.createAll(SubscriptionPlans.BASIC.getSubscriptionPlan(),
										  SubscriptionPlans.STANDARD.getSubscriptionPlan(),
										  SubscriptionPlans.PREMIUM.getSubscriptionPlan());

		//@formatter:off
		var firstAccount = Account.builder()
								  .email("c.giannacoulis@codehub.g")
								  .password("test123")
								  .subscriptionPlan(subscriptionPlanService.getByTitle("STANDARD")).build();

		var firstCreditCard = CreditCard.builder()
										.cardNumber("1234432156788765")
										.cardHolder("XXX")
										.expirationDate("01/27")
										.securityCode(123).build();

		accountService.addCreditCard(firstAccount, firstCreditCard);
		firstAccount.setProfiles(Set.of(com.acmeflix.domain.Profile.builder()
																   .name("adult1")
																   .language(Language.ENGLISH)
																   .viewingRestriction(ViewingRestriction.ALL)
																   .account(firstAccount)
																   .build(),
										com.acmeflix.domain.Profile.builder()
																   .name("adult2")
																   .language(Language.ENGLISH)
																   .viewingRestriction(ViewingRestriction.EIGHTEEN)
																   .account(firstAccount)
																   .build()));

		var firstAccountSaved = accountService.create(firstAccount);
		logger.info("Account saved: {}.", firstAccountSaved);

		var firstAccountRetrieved = accountService.get(firstAccountSaved.getId());
		logger.info("Account retrieved: {}.", firstAccountRetrieved);

		var firstAccountFullyRetrieved = accountService.getFullContent(firstAccountSaved.getId());
		logger.info("Account retrieved: {}.", firstAccountFullyRetrieved);

		// Create first movie
		Movie firstMovie = Movie.builder()
								.title("Man From Toronto")
								.plot("The world's deadliest assassin and New York's biggest screw-up are mistaken for each other at an Airbnb rental.")
								.releaseYear(2022)
								.durationInMinutes(112)
								.genres(Set.of(Genre.ACTION, Genre.COMEDY))
								.viewingRestriction(ViewingRestriction.THIRTEEN)
								.audioLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								.subtitleLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								.build();
		// Create second movie
		Movie secondMovie = Movie.builder()
								 .title("Red Notice")
								 .plot("An Interpol agent successfully tracks down the world's most wanted art thief, with help from a rival thief. But nothing is as it seems, as a series of double-crosses ensue.")
								 .releaseYear(2022)
								 .durationInMinutes(118)
								 .genres(Set.of(Genre.ACTION, Genre.COMEDY))
								 .viewingRestriction(ViewingRestriction.THIRTEEN)
								 .audioLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								 .subtitleLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								 .build();

		// Set second movie as a recommendation to the first one
		firstMovie.setRecommendations(Set.of(secondMovie));

		movieService.createAll(firstMovie, secondMovie);

		// First TV Show
		TvShow firstTvShow = TvShow.builder()
								   .title("Stranger Things")
								   .plot("When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.")
								   .releaseYear(2016)
								   .genres(Set.of(Genre.ACTION, Genre.COMEDY))
								   .viewingRestriction(ViewingRestriction.THIRTEEN)
								   .audioLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								   .subtitleLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								   .seasons(Set.of(
										   Season.builder()
												 .title("Season 1")
												 .ordering(1)
												 .releaseYear(2016)
												 .episodes(Set.of(
														 Episode.builder().title("Chapter One: The Vanishing of Will Byers").durationInMinutes(49).build(),
														 Episode.builder().title("Chapter Two: The Weirdo on Maple Street").durationInMinutes(56).build(),
														 Episode.builder().title("Chapter Three: Holly, Jolly").durationInMinutes(52).build(),
														 Episode.builder().title("Chapter Four: The Body").durationInMinutes(51).build()))
												 .build(),
										   Season.builder()
												 .title("Season 2")
												 .ordering(2)
												 .releaseYear(2017)
												 .episodes(Set.of(
														 Episode.builder().title("Chapter One: MADMAX").durationInMinutes(48).build(),
														 Episode.builder().title("Chapter Two: Trick or Treat, Freak").durationInMinutes(56).build(),
														 Episode.builder().title("Chapter Three: The Pollywog").durationInMinutes(51).build(),
														 Episode.builder().title("Chapter Four: Will the Wise").durationInMinutes(46).build()))
												 .build(),
										   Season.builder()
												 .title("Season 3")
												 .ordering(3)
												 .releaseYear(2019)
												 .episodes(Set.of(
														 Episode.builder().title("Chapter One: Suzie, Do You Copy?").durationInMinutes(51).build(),
														 Episode.builder().title("Chapter Two: The Mall Rats").durationInMinutes(50).build(),
														 Episode.builder().title("Chapter Three: The Case of the Missing Lifeguard").durationInMinutes(50).build(),
														 Episode.builder().title("Chapter Four: The Sauna Test").durationInMinutes(53).build()))
												 .build(),
										   Season.builder()
												 .title("Season 4")
												 .ordering(4)
												 .releaseYear(2022)
												 .episodes(Set.of(
														 Episode.builder().title("Chapter One: The Hellfire Club").durationInMinutes(78).build(),
														 Episode.builder().title("Chapter Two: Vecna's Curse").durationInMinutes(77).build(),
														 Episode.builder().title("Chapter Three: The Monster and the Superhero").durationInMinutes(64).build(),
														 Episode.builder().title("Chapter Four: Dear Billy").durationInMinutes(79).build()))
												 .build()))
								   .build();
		// setting TV Show for each season
		firstTvShow.getSeasons().forEach(season -> season.setTvShow(firstTvShow));

		// setting season for each episode
		firstTvShow.getSeasons().forEach(season -> season.getEpisodes().forEach(episode -> episode.setSeason(season)));

		tvShowService.create(firstTvShow);

		// Using services now
		var secondTvShow = TvShow.builder()
								 .title("Peaky Blinders")
								 .plot("A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.")
								 .releaseYear(2013)
								 .genres(Set.of(Genre.ACTION, Genre.DRAMA))
								 .viewingRestriction(ViewingRestriction.THIRTEEN)
								 .audioLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								 .subtitleLanguages(Set.of(Language.ENGLISH, Language.GREEK))
								 .build();

		tvShowService.addSeasons(secondTvShow,
								 Season.builder().title("Season 1").ordering(1).releaseYear(2013).build(),
								 Season.builder().title("Season 2").ordering(2).releaseYear(2014).build(),
								 Season.builder().title("Season 3").ordering(3).releaseYear(2016).build(),
								 Season.builder().title("Season 4").ordering(4).releaseYear(2017).build(),
								 Season.builder().title("Season 5").ordering(5).releaseYear(2019).build(),
								 Season.builder().title("Season 6").ordering(6).releaseYear(2022).build());

		tvShowService.create(secondTvShow);

		var secondTvShowRetrieved = tvShowService.getFullContent(4L);

		tvShowService.addEpisodes(tvShowService.getSeason(secondTvShowRetrieved, 5),
								  Episode.builder().title("Black Day").durationInMinutes(55).build(),
								  Episode.builder().title("Black Shirt").durationInMinutes(59).build(),
								  Episode.builder().title("Gold").durationInMinutes(56).build(),
								  Episode.builder().title("Sapphire").durationInMinutes(59).build(),
								  Episode.builder().title("The Road to Hell").durationInMinutes(59).build(),
								  Episode.builder().title("Lock and Key").durationInMinutes(82).build());

		tvShowService.update(secondTvShowRetrieved);


		personService.createAll(Person.builder().firstName("Cillian").lastName("Murphy").build(),
								Person.builder().firstName("Paul").lastName("Anderson").build());

		var cillianMurphy = personService.findByLastNameAndFirstName("MURPHY", "Cillian");
		var paulAnderson = personService.findByLastNameAndFirstName("ANDERSON", "Paul");

		castMemberService.create(CastMember.builder()
										   .person(cillianMurphy)
										   .content(secondTvShowRetrieved).role(Role.ACTOR).build());
		castMemberService.create(CastMember.builder()
										   .person(paulAnderson)
										   .content(secondTvShowRetrieved)
										   .role(Role.ACTOR)
										   .build());

		//@formatter:on

		logger.info("Submitting ratings.");
		var retrievedFirstAccount = accountService.getFullContent(1L);
		accountService.rate(retrievedFirstAccount.getProfile("me"), movieService.getFullContent(1L), 4.5d);
		accountService.rate(retrievedFirstAccount.getProfile("me"), movieService.getFullContent(2L), 4d);

		// Enable the following line to check whether validation works
		// accountService.rate(retrievedFirstAccount.getProfile("kiddo"), movieService.get(2L), 4d);
		accountService.rate(retrievedFirstAccount.getProfile("me"), tvShowService.get(3L), 5d);
		accountService.rate(retrievedFirstAccount.getProfile("me"), tvShowService.get(4L), 5d);

		var retrievedSecondAccount = accountService.getFullContent(2L);
		accountService.rate(retrievedSecondAccount.getProfile("adult1"), movieService.get(1L), 4.5d);
		accountService.rate(retrievedSecondAccount.getProfile("adult1"), movieService.get(2L), 4d);
		accountService.rate(retrievedSecondAccount.getProfile("adult1"), tvShowService.get(3L), 5d);
		accountService.rate(retrievedSecondAccount.getProfile("adult1"), tvShowService.get(4L), 4.5d);
		accountService.rate(retrievedSecondAccount.getProfile("adult2"), movieService.get(1L), 4d);
		accountService.rate(retrievedSecondAccount.getProfile("adult2"), movieService.get(2L), 4d);
		accountService.rate(retrievedSecondAccount.getProfile("adult2"), tvShowService.get(3L), 4.5d);
		accountService.rate(retrievedSecondAccount.getProfile("adult2"), tvShowService.get(4L), 4.5d);

		logger.info("Retrieving ratings.");
		movieService.getRatings().forEach(movie -> {
			logger.debug("Movie '{}' was rated {}.", movie.getTitle(),
						 String.format("%3.2f", movie.getRatings().stream().mapToDouble(Rating::getRate).average()
													 .getAsDouble()));
		});
		tvShowService.getRatings().forEach(tvShow -> {
			logger.debug("TV Show '{}' was rated {}.", tvShow.getTitle(),
						 String.format("%3.2f", tvShow.getRatings().stream().mapToDouble(Rating::getRate).average()
													  .getAsDouble()));
		});
	}
}
