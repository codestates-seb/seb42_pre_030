import styled, { createGlobalStyle } from "styled-components";

import Header from '../components/template/Header'
import Sidebar from '../components/template/Sidebar';
import QuestionList from '../components/main/QuestionList'


const HomeLoginPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 500px;
    
`

    return (
        <>
            <Header />
            <MainBar>
                <Sidebar />
                <QuestionList />
            </MainBar>
        </>
    )
}

export default HomeLoginPage;