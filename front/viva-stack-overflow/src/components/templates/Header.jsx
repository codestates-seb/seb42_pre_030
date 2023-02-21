import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import "../../assets/styles/variable.css";
import homeButton from '../../assets/imgs/--logo--home.png';

const Header = () => {

    const Headers = styled.div`
        display: flex;
        justify-content: center;
        background-color: #f8f9f9;
        border-top: 3px solid var(--viva-orange-200);
        height: 50px;
        width: 100%;
        box-shadow: 0 1px 2px hsla(0,0%,0%,0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05), 0 2px 8px hsla(0, 0%, 0%, 0.05);
        position: fixed;
    `

    const TopbarContainer = styled.nav`
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
    `

    const TopbarBox1 = styled.div`
        display: flex;
        align-items: center;
    `

    const HomeLogo = styled.img`
            padding: 10px;
            width: 150px;
    `

    const TopbarBox2 = styled.div`
        display: flex;
        margin-left: 20px;
    `

    const SearchBox = styled.input`
        display: flex;
        width: 70vh;
        height: 24px;
    `

    const TopbarBox3 = styled.div`
        display: flex;
        margin-left: 10px;
    `

    const TopbarButtonContainer = styled.div`
        display: flex;
        margin-left: 10px;
        text-decoration-line: none;
    `

    const LoginButton = styled.button`
        border: 1px solid var(--viva-blue-400);
        border-radius: 4px;
        color: var(--viva-blue-400);
        background-color: aliceblue;
        height: 25px;
        cursor: pointer;
    `

    const SignupButton = styled.button`
        border: 1px solid var(--viva-blue-400);
        border-radius: 4px;
        color: aliceblue;
        background-color: var(--viva-blue-400);
        height: 25px;
        cursor: pointer;
    `

    const OpenMypage = styled.img`
        height: 25px;
        cursor: pointer;
        border: 1px solid var(--viva-blue-400);
        border-radius: 4px;
    `

    return (
        <>
            <Headers>
                <TopbarContainer>
                    <TopbarBox1>
                        <a href='https://stackoverflow.com/'>
                            <HomeLogo src={homeButton} alt="logo" />
                        </a>
                    </TopbarBox1>
                    <TopbarBox2>
                        <SearchBox placeholder='Search' maxLength={'240'}></SearchBox>
                    </TopbarBox2>
                    <TopbarBox3>
                        <TopbarButtonContainer href='/login' ><LoginButton>Log in</LoginButton></TopbarButtonContainer>
                        <TopbarButtonContainer href='/signup' ><SignupButton>Sign up</SignupButton></TopbarButtonContainer>
                        {/*<TopbarButtonContainer href='/mypage' ><img className='topbar--item mypage' src='anything.ng'></img></TopbarButtonContainer>*/}
                    </TopbarBox3>
                </TopbarContainer>
            </Headers>
        </>
    )
}

export default Header