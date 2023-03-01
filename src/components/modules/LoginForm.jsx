/* eslint-disable */

import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import "../../assets/styles/variable.css";
import icon_fb from "../../assets/IMG/--icon--facebook.png";
import icon_google from "../../assets/IMG/--icon--google.png";
import icon_github from "../../assets/IMG/--icon--github.png";
import logo_stackoverflow from "../../assets/IMG/--logo--toss.png";
import Header from "../template/Header";
import axios from "axios";

export const GlobalStyle = createGlobalStyle`
body {
    box-sizing: content-box;
    background-color: var(--gray-100);
}
`;

export const Main = styled.div`
    width: 100%;
    min-height: 100vh;
    padding:40px 0;
    box-sizing:border-box;
    display: flex;
    justify-content: center;
    align-items: center;
`;
export const Components = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
`;
const StackoverflowImg = styled.img.attrs({
    src: `${logo_stackoverflow}`
})`
    width: 32px;
    height:37px;
    margin-bottom: 24px;
`;

export const SocialLoginBtn = styled.div`
    height: 14.992px;
    width: 245.242px;
    border: 1px solid #dbdbdb;
    border-radius: 5px;
    margin: 4px 0;
    padding: 10.4px;
    font-size: 13px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: ${(props) => props.bgcolor ? props.bgcolor : "white"};
    color: ${(props) => props.color ? props.color : "black"};

    cursor: pointer;
    &:hover {
      background-color: ${(props) => props.hcolor ? props.hcolor : "black"};
  }
`;

export const LoginBtn = styled(SocialLoginBtn)`
    width:207.2px;
    height:14.981px;
    padding:10.4px;
    margin:2px;
    background-color: var(--viva-blue-300);
    border:1px solid transparent;
    box-shadow:inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
    &:hover {
      background-color: var(--h-4);
  }
`;

export const SocialBtn = ({ name, href, bgcolor, color, hcolor }) => {
    return (
        <SocialLoginBtn bgcolor={bgcolor} color={color} hcolor={hcolor}>
            <img src={href} alt="아이콘 이미지" width="15px"></img>
            <span>Log in with {name}</span>
        </SocialLoginBtn>
    )
}
export const LoginBox = styled.form`
    height: 186.188px;
    width: 230px;
    /* border: 1px solid #dbdbdb; */
    border-radius: 7px;
    margin-top: 16px;
    margin-bottom: 24px;
    padding: 24px;
    background-color: white;
    box-shadow: 0 10px 24px hsla(0,0%,0%,0.05), 0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);
    display: flex;
    flex-direction: column;
`;
export const InputForm = styled.div`
    margin:6px 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
`

export const Label = styled.label`
    cursor: pointer;
    font-weight: 500;
    padding: 0 2px;
    margin: 2px 0;
    color: var(--gray-600);
    display: flex;
    justify-content: space-between;
    align-items: center;
`;
export const LoginInput = styled.input`
    width: 209.800px;
    height: 14.994px;
    /* border: 1px solid hsl(210, 8%, 100%); */
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    padding: 7.8px 9.1px;
    outline:none;
`;
export const SLink = styled.a`
    color:var(--viva-blue-400);
    cursor: pointer;
    text-decoration: none;
    font-size: 12px;
    font-weight: 400;
`;

export const LinkBox = styled.div`
    padding:16px;
    margin-bottom: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
`;

export const Etc = styled.div`
    font-size: 12px;
    letter-spacing: 0.5px;
    margin-bottom: 10px;
    color:var(--gray-500);
`;
export const Btn = styled.button`
    width:230px;
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
`;
export const LoginForm = () => {
    const URI = "http://ec2-3-35-220-165.ap-northeast-2.compute.amazonaws.com:8080";
    const { register, handleSubmit, formState: { errors } } = useForm();

    const onSubmit = async (data) => {
        console.log(data);
        await axios({
            method: 'post',
            // url: `/members`,
            url: `${URI}/auth/login`,
            params: {},
            data: data,
        }, { withCredentials: true })

            .then((res) => {
                alert('로그인 성공')
            })
            .catch((err) => { console.log(err) })
    };

    const onError = (error) => {
        console.log(error);
    };

    const Errorspan = styled.span`
    color:red;  
    font-size: 12px;
    `

    return (
        <>
            <GlobalStyle />
            <Header />
            <Main>
                <Components>
                    <StackoverflowImg />
                    <SocialBtn name={'Google'} href={icon_google} hcolor="var(--h-1)" />
                    <SocialBtn name={'GitHub'} href={icon_github} bgcolor="var(--gray-400)" color="white" hcolor="var(--h-2)" />
                    <SocialBtn name={'Facebook'} href={icon_fb} bgcolor="var(--viva-blue-500)" color="white" hcolor="var(--h-3)" />
                    <LoginBox onSubmit={handleSubmit(onSubmit, onError)}>
                        <InputForm>
                            <Label htmlFor="username">Email</Label>
                            <LoginInput type="text" maxLength={100} name="username"
                                {...register("username", {
                                    required: "username is required"
                                })} />
                                <Errorspan>{errors.username && errors.username.message}</Errorspan>
                        </InputForm>
                        <InputForm>
                            <Label htmlFor="password">Password
                                <SLink href="https://stackoverflow.com/users/account-recovery">Forgot password?</SLink>
                            </Label>
                            <LoginInput type="password" autoComplete="off" name="password" id="password"
                                {...register("password", {
                                    required: "password is required"
                                })} />
                                <Errorspan>{errors.password && errors.password.message}</Errorspan>
                        </InputForm>
                        <InputForm>
                            <Btn type="submit" color="white">Log in</Btn>
                        </InputForm>
                    </LoginBox>
                    <LinkBox>
                        <Etc>Don't have an account? <SLink>Sign up</SLink></Etc>
                        <Etc>Are you an employer? <SLink>Sign up on Talent</SLink></Etc>
                    </LinkBox>
                </Components>
            </Main>
        </>
    )
}

export default LoginForm;