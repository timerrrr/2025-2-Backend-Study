package com.example.shop.member;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //@Transactional
    public Long createMember(MemberCreateRequest request){
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if(existingMember != null){
            throw new RuntimeException("이미 존재하는 로그인 아이디입니다: " + request.getLoginId());
        }

        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );

        memberRepository.save(member);

        return member.getId();
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        Member member = memberRepository.findById(id);

        if(member == null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        return member;
    }

    public void updateMember(Long id, MemberUpdateRequest request){
        Member member = memberRepository.findById(id);

        if(member == null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        member.updateInfo(request.getPassword(), request.getPhoneNumber(), request.getAddress());
    }

    public void deleteMember(Long id){
        Member member = memberRepository.findById(id);

        if(member == null){
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        memberRepository.deleteById(id);
    }
}
