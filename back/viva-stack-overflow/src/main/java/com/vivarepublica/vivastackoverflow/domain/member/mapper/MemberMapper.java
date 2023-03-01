package com.vivarepublica.vivastackoverflow.domain.member.mapper;

import com.vivarepublica.vivastackoverflow.domain.member.dto.MemberDto;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post memberPostDto);
    Member memberPatchDtoToMember(MemberDto.Patch memberPatchDto);
    @Mapping(source = "prettyCreatedAt", target = "createdAt")
    @Mapping(source = "prettyModifiedAt", target = "modifiedAt")
    MemberDto.Response memberToMemberResponseDto(Member member);
}
