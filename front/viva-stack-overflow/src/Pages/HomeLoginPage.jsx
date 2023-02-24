import styled, { createGlobalStyle } from "styled-components";

import Sidebar from '../Components/Template/Sidebar';
import QuestionList from '../Components/Mains/QuestionList'
import HeaderWithLogin from "../Components/Template/HeaderWithLogin";


const HomeLoginPage = function () {

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
                <QuestionList />
            </MainBar>
        </>
    )
}

export default HomeLoginPage;