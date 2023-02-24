import styled, { createGlobalStyle } from "styled-components";
import UserInfoMain from "../Components/Mains/UserInfoMain";

import Header from '../Components/Template/Header'
import HeaderWithLogin from "../Components/Template/HeaderWithLogin";
import Sidebar from '../Components/Template/Sidebar';


const UserInfoPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 500px;
    
`

    return (
        <>
            <HeaderWithLogin />
            <MainBar>
                <Sidebar />
                <UserInfoMain />
            </MainBar>
        </>
    )
}

export default UserInfoPage;