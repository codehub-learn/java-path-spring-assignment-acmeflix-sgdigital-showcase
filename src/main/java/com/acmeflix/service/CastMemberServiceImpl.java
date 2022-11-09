package com.acmeflix.service;

import com.acmeflix.domain.CastMember;
import com.acmeflix.repository.CastMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CastMemberServiceImpl extends BaseServiceImpl<CastMember> implements CastMemberService {
	private final CastMemberRepository castMemberRepository;

	@Override
	public JpaRepository<CastMember, Long> getRepository() {
		return castMemberRepository;
	}
}
