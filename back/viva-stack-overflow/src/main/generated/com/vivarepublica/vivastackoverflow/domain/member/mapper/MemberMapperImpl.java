package com.vivarepublica.vivastackoverflow.domain.member.mapper;

import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T10:58:10+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberDto.Post memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostDto.getEmail() );
        member.setPassword( memberPostDto.getPassword() );
        member.setNickname( memberPostDto.getNickname() );

        return member;
    }

    @Override
    public MemberDto.Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        Long memberId = null;
        String email = null;
        String nickname = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        nickname = member.getNickname();

        MemberDto.Response response = new MemberDto.Response( memberId, email, nickname );

        return response;
    }
}
