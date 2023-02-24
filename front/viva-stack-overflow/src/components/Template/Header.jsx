import { useState } from "react";

import styled from "styled-components";
import "../../Assets/STYLES/GlobalStyle";
import homeButton from '../../Assets/IMG/--logo--viva--black.png';
import dummydata from '../../Data/dummydata.json'
import { Link } from "react-router-dom";

const Header = () => {

    const Headers = styled.div`
    align-items: center;
    box-sizing: border-box;
    background-color: rgb(248, 249, 249);
    border-top: 3px solid var(--viva-blue-600);
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), 0 1px 4px rgba(0, 0, 0, 0.05), 0 2px 8px rgba(0, 0, 0, 0.05);
    display: flex;
    height: 60px;
    left: 0;
    position: sticky;
    width: 100vw;
    z-index: 999;
    justify-content: space-around;
    `

    const TopbarContainer = styled.nav`
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-evenly;
    `

    const TopbarBox1 = styled.div`
        display: flex;
        align-items: center;
    `

    const HomeLogo = styled.img`
            display: flex;
            align-items: center;
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
        `

    const LoginOutButton = styled.button`
        all: unset;
        background-color: rgb(225, 236, 244);
        box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.3);
        border: 1px solid rgb(57, 115, 157);
        border-radius: 3px;
        color: rgb(57, 115, 157);
        font-size: 14px;
        font-weight: 400;
        height: 32px;
        text-align: center;
        width: 60px;
        &:hover {
            background-color: rgb(185, 210, 232);
        }
        `

    const SignUpButton = styled(LoginOutButton)`
        background-color: rgb(10, 149, 255);
        color: rgb(255, 255, 255);
        width: 65px;
        &:hover {
            background-color: rgb(49, 114, 198);
        }
        `;





    return (
        <>
            <Headers>
                <TopbarContainer>
                    <TopbarBox1>
                        <Link to={"/"}>
                            <HomeLogo src={homeButton} alt="logo" />
                        </Link>
                    </TopbarBox1>
                    <TopbarBox2>
                        <SearchBox type="text" placeholder='Search' maxLength={'240'}></SearchBox>
                    </TopbarBox2>
                    <TopbarBox3>
                        <Link to={"/login"} style={{ textDecoration: 'none' }}>
                            <TopbarButtonContainer href='/login' ><LoginOutButton>Log in</LoginOutButton></TopbarButtonContainer>
                        </Link>
                        <Link to={"/signup"} style={{ textDecoration: 'none' }}>
                            <TopbarButtonContainer href='/signup' ><SignUpButton>Sign up</SignUpButton></TopbarButtonContainer>
                        </Link>
                        {/*<TopbarButtonContainer href='/mypage' ><img className='topbar--item mypage' src='anything.ng'></img></TopbarButtonContainer>*/}
                    </TopbarBox3>
                </TopbarContainer>
            </Headers>
        </>
    )
}

export default Header