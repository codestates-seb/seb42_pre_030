import styled, { createGlobalStyle } from "styled-components";
import UserInfoMain from "../components/main/UserInfo";

import Header from '../components/template/Header'
import HeaderWithLogin from "../components/template/HeaderWithLogin";
import Sidebar from '../components/template/Sidebar';


const UserInfoPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 100%;
    justify-content: center;
`

    return (
        <>
            <Header />
            <MainBar>
                <Sidebar />
                <UserInfoMain />
            </MainBar>
        </>
    )
}

export default UserInfoPage;