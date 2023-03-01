import styled, { createGlobalStyle } from "styled-components";

import Sidebar from '../components/template/Sidebar';
import QuestionList from '../components/main/QuestionList'
import HeaderWithLogin from "../components/template/HeaderWithLogin";


const HomeLoginPage = function () {

    const MainBar = styled.div`
    display: flex;
    justify-content: center;
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