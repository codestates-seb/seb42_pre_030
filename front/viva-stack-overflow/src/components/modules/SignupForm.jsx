import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import ReCAPTCHA from "./ReCAPTCHA";
import "../../Assets/STYLES/variable.css";
import icon_fb from "../../Assets/IMG/--icon--facebook.png";
import icon_google from "../../Assets/IMG/--icon--google.png";
import icon_github from "../../Assets/IMG/--icon--github.png";
import icon_q from "../../Assets/imgs/--icon--question-mark.png";
import icon_bq from "../../Assets/imgs/--icon--blue--question-mark.png";
import icon_vote from "../../Assets/imgs/--icon--blue--vote.png";
import icon_tag from "../../Assets/imgs/--icon--blue--tag.png";
import icon_trophy from "../../Assets/imgs/--icon--blue--trophy.png";
import * as LoginForm from './Login';


const Container = styled.div`
    display: flex;
`;
const SectionL = styled.section`
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-right:48px;
    margin-bottom: 128px;
`;
const SectionR = styled.section`
`;
const H1 = styled.h1`
    font-weight: 400;
    color:var(--gray-500);
    margin-top:0;
    margin-bottom: 32px;
`;
const Item = styled.div`
    font-size: 15px;
    margin-bottom: 24px;
    color:var(--gray-500);
`;

const SignupBox = styled(LoginForm.LoginBox)`
    height:596.203px;
    width:268px;
`;
const SocialBtn = ({ name, href, bgcolor, color }) => {
    return (
        <SocialLoginBtn bgcolor={bgcolor} color={color}>
            <img src={href} alt="아이콘 이미지" width="15px"></img>
            <span>Log in with {name}</span>
        </SocialLoginBtn>
    )
}
const BlueIcon = ({ href }) => {
    return (
        <>
            <Op>
                <img src={href} alt="아이콘 이미지" width="17px"></img>
            </Op>
        </>
    )
}
const Op = styled.span`
filter:brightness(130%);
`;
const Icon = styled.img.attrs({
    src: `${icon_q}`
})`
    width:16px;
    opacity:60%;
`
const SocialLoginBtn = styled(LoginForm.SocialLoginBtn)`
    height:14.987px;
    width:293.200px;
`;

const LoginBtn = styled(LoginForm.LoginBtn)`
    width:244.981px;
    height:14.999px;
    border:none; 
    border:1px solid transparent;
    border-radius: 3px;
    box-shadow:inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
    margin-top:15px;
    margin-bottom: 32px;
    /* box-shadow: inset 0 1px 0 0 hsla(0,0%,100%,0.7); */
`;
const Etc = styled(LoginForm.Etc)`
    font-size:12px;
    letter-spacing: 0;
    color:hsl(210,8%,45%);
    margin:4px 0;
`;
const LoginInput = styled(LoginForm.LoginInput)`
    width:247.8px;
    height:14.994px;
    border:1px solid hsl(210, 8%, 75%);
`;
const Optin = styled.label`
    font-size:13px;
    color:var(--gray-600);
`
const Form = styled.div`
    display: flex;
    align-items: baseline;
`

const SignupForm = () => {
    return (
        <>
            <LoginForm.GlobalStyle />
            <LoginForm.Main>
                <Container>
                    <SectionL>
                        <H1>Join the Stack Overflow community</H1>
                        <Item><BlueIcon href={icon_bq} /> Get unstuck -- ask a question</Item>
                        <Item><BlueIcon href={icon_vote} /> Unlock new privileges like voting and commenting</Item>
                        <Item><BlueIcon href={icon_tag} /> Save your favorite tags, filters, and jobs</Item>
                        <Item><BlueIcon href={icon_trophy} /> Earn reputation and badges</Item>
                        <Etc>Collaborate and share knowledge with a private group for FREE. </Etc>
                        <LoginForm.SLink>Get Stack Overflow for Teams free for up to 50 users.</LoginForm.SLink>
                    </SectionL>
                    <SectionR>
                        <SocialBtn name={'Google'} href={icon_google} />
                        <SocialBtn name={'GitHub'} href={icon_github} bgcolor="var(--gray-400)" color="white" />
                        <SocialBtn name={'Facebook'} href={icon_fb} bgcolor="var(--viva-blue-500)" color="white" />
                        <SignupBox>
                            <LoginForm.InputForm>
                                <LoginForm.Label for="display-name">Display name</LoginForm.Label>
                                <LoginInput type="text" name="display-name"></LoginInput>
                            </LoginForm.InputForm>
                            <LoginForm.InputForm>
                                <LoginForm.Label for="email">Email</LoginForm.Label>
                                <LoginInput type="email" autoComplete="off" maxLength={100} name="email"></LoginInput>
                            </LoginForm.InputForm>
                            <LoginForm.InputForm>
                                <LoginForm.Label for="password">Password</LoginForm.Label>
                                <LoginInput type="password" autoComplete="off" name="password" id="password"></LoginInput>
                                <Etc>Passwords must contain at least eight characters, including at least 1 letter and 1 number.</Etc>
                            </LoginForm.InputForm>
                            <LoginForm.InputForm>
                                <ReCAPTCHA />
                            </LoginForm.InputForm>
                            <Form>
                                <input type="checkbox"></input>
                                <Optin>Opt-in to receive occasional product updates, user research invitations, company announcements, and digests.</Optin>
                                <Icon />
                            </Form>
                            <LoginForm.InputForm>
                                <LoginBtn color="white">Sign up</LoginBtn>
                            </LoginForm.InputForm>
                            <Etc>By clicking "Sign up", you agree to our <LoginForm.SLink>terms of service, privacy policy</LoginForm.SLink> and <LoginForm.SLink>cookie policy</LoginForm.SLink></Etc>
                        </SignupBox>
                        <LoginForm.LinkBox>
                            <LoginForm.Etc>Already have an account? <LoginForm.SLink>Log in</LoginForm.SLink></LoginForm.Etc>
                            <LoginForm.Etc>Are you an employer? <LoginForm.SLink>Sign up on Talent</LoginForm.SLink></LoginForm.Etc>
                        </LoginForm.LinkBox>
                    </SectionR>
                </Container>
            </LoginForm.Main>

        </>
    )
}

export default SignupForm