import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import ReCAPTCHA from "./ReCAPTCHA";
import "../../assets/styles/variable.css";
import icon_fb from "../../assets/IMG/--icon--facebook.png";
import icon_google from "../../assets/IMG/--icon--google.png";
import icon_github from "../../assets/IMG/--icon--github.png";
import icon_q from "../../assets/IMGS/--icon--question-mark.png";
import icon_bq from "../../assets/IMGS/--icon--blue--question-mark.png";
import icon_vote from "../../assets/IMGS/--icon--blue--vote.png";
import icon_tag from "../../assets/IMGS/--icon--blue--tag.png";
import icon_trophy from "../../assets/IMGS/--icon--blue--trophy.png";
import * as LoginForm from '../modules/LoginForm';
import axios from "axios";
import Header from "../template/Header";

const GlobalStyle = createGlobalStyle`
body {
    box-sizing: content-box;
    background-color: var(--gray-100);
}
`;

const SignUpContainer = styled.div`
display: flex;
flex-wrap: wrap;
/* width: 840px; */
padding: 100px 0;
/* height: 100vh; */
justify-content: center;
align-items: center;
min-height:100vh;
`

const Container = styled.div`
    display: flex;
    /* height: 500px; */
    /* align-items: flex-start; */
    /* width: 840px; */
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
const SocialBtn = ({ name, href, bgcolor, color, hcolor }) => {
    return (
        <SocialLoginBtn bgcolor={bgcolor} color={color} hcolor={hcolor}>
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
    border-radius: 3px;
    margin-top:15px;
    margin-bottom: 32px;

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
const Btn = styled.button`
    width:270px;
    padding:10px;
    margin:4px 0;
    display: flex;
    justify-content: center;
    align-items: center;
    border:none;
    border-radius: 5px;
    background-color:var(--viva-blue-300);
    border:1px solid transparent;
    color:white;
    cursor: pointer;
    box-shadow:inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
    &:hover {
      background-color: var(--h-4);
  }
`

export const SignupForm = () => {
    const URI = "https://a202-39-121-143-132.jp.ngrok.io";
    const { register, handleSubmit, formState: { errors } } = useForm();
    const onSubmit = async (data) => {
        console.log(data);
        await axios({
            method: 'post',
            // url: `/members`,
            url: `${URI}/members`,
            params: {},
            data: data,
        }, { withCredentials: true })

            .then((res) => {
                alert('회원가입 완료')
            })
            .catch((err) => { console.log(err) })
    };
    const onError = (error) => {
        console.log(error);
    };

    const Errorspan = styled.span`
    color:red;  
    font-size: 12px;
`;
    return (
        <>
            <GlobalStyle />
            <Header /> 
            <SignUpContainer>
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
                        <SocialBtn name={'Google'} href={icon_google} hcolor="var(--h-1)" />
                        <SocialBtn name={'GitHub'} href={icon_github} bgcolor="var(--gray-400)" color="white" hcolor="var(--h-2)" />
                        <SocialBtn name={'Facebook'} href={icon_fb} bgcolor="var(--viva-blue-500)" color="white" hcolor="var(--h-3)" />
                        <SignupBox onSubmit={handleSubmit(onSubmit, onError)}>
                            <LoginForm.InputForm>
                                <LoginForm.Label>Display name</LoginForm.Label>
                                <LoginInput type="text" name="nickname" style={{ border: errors.nickname ? "1px solid red" : "" }}
                                    {...register("nickname", {
                                        required: "Username is required.",
                                        minLength: {
                                            value: 5,
                                            message: "Username must be longer than 5 characters."
                                        }
                                    })}></LoginInput>
                                <Errorspan>{errors.nickname && errors.nickname.message}</Errorspan>
                            </LoginForm.InputForm>
                            <LoginForm.InputForm>
                                <LoginForm.Label>Email</LoginForm.Label>
                                <LoginInput type="text" autoComplete="off" maxLength={100} name="email" style={{ border: errors.nickname ? "1px solid red" : "" }}
                                    {...register("email", {
                                        required: "email is required.",
                                        pattern:{
                                            value:/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i, 
                                            message:`not a valid email addredd.`}
                                    })}></LoginInput>
                                <Errorspan>{errors.email && errors.email.message}</Errorspan>
                            </LoginForm.InputForm>
                            <LoginForm.InputForm>
                                <LoginForm.Label>Password</LoginForm.Label>
                                <LoginInput type="password" autoComplete="off" name="password" id="password" style={{ border: errors.nickname ? "1px solid red" : "" }}
                                    {...register("password", {
                                        required: "password is required.",
                                        minLength: {
                                            value: 8,
                                            message: "password must be longer than 8 characters."
                                        }
                                    })}></LoginInput>
                                <Errorspan>{errors.password && errors.password.message}</Errorspan>
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
                                <Btn color="white" type="submit">Sign up</Btn>
                            </LoginForm.InputForm>
                            <Etc>By clicking "Sign up", you agree to our <LoginForm.SLink>terms of service, privacy policy</LoginForm.SLink> and <LoginForm.SLink>cookie policy</LoginForm.SLink></Etc>
                        </SignupBox>
                        <LoginForm.LinkBox>
                            <LoginForm.Etc>Already have an account? <LoginForm.SLink>Log in</LoginForm.SLink></LoginForm.Etc>
                            <LoginForm.Etc>Are you an employer? <LoginForm.SLink>Sign up on Talent</LoginForm.SLink></LoginForm.Etc>
                        </LoginForm.LinkBox>
                    </SectionR>
                </Container>
            </SignUpContainer>
        </>
    )
}

export default SignupForm