package com.vivarepublica.vivastackoverflow.domain.member.mapper;

import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post memberPostDto);
    Member memberPatchDtoToMember(MemberDto.Patch memberPatchDto);
    MemberDto.Response memberToMemberResponseDto(Member member);
}
