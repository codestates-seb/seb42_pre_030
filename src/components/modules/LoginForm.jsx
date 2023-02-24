/* eslint-disable */

import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import "../../assets/styles/variable.css";
import icon_fb from "../../assets/IMG/--icon--facebook.png";
import icon_google from "../../assets/IMG/--icon--google.png";
import icon_github from "../../assets/IMG/--icon--github.png";
import logo_stackoverflow from "../../assets/IMG/--logo--toss.png";

export const GlobalStyle = createGlobalStyle`
body {
    box-sizing: content-box;
    background-color: var(--gray-100);
}
`;

export const Main = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 24px 280px;
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
`;

export const LoginBtn = styled(SocialLoginBtn)`
    width:207.2px;
    height:14.981px;
    padding:10.4px;
    margin:2px;
    background-color: var(--viva-blue-300);
`;

export const SocialBtn = ({ name, href, bgcolor, color }) => {
    return (
        <SocialLoginBtn bgcolor={bgcolor} color={color}>
            <img src={href} alt="아이콘 이미지" width="15px"></img>
            <span>Log in with {name}</span>
        </SocialLoginBtn>
    )
}
export const LoginBox = styled.div`
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

export const LoginForm = () => {
    return (
        <>
            <GlobalStyle />
            <Main>
                <Components>
                    <StackoverflowImg />
                    <SocialBtn name={'Google'} href={icon_google} />
                    <SocialBtn name={'GitHub'} href={icon_github} bgcolor="var(--gray-400)" color="white" />
                    <SocialBtn name={'Facebook'} href={icon_fb} bgcolor="var(--viva-blue-500)" color="white" />
                    <LoginBox>
                        <InputForm>
                            <Label for="email">Email</Label>
                            <LoginInput type="email" maxLength={100} name="email" />
                        </InputForm>
                        <InputForm>
                            <Label for="password">Password
                                <SLink href="https://stackoverflow.com/users/account-recovery">Forgot password?</SLink>
                            </Label>
                            <LoginInput type="password" autoComplete="off" name="password" id="password" />
                        </InputForm>
                        <InputForm>
                            <LoginBtn color="white">Log in</LoginBtn>
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
