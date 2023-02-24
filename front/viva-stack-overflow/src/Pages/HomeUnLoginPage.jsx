import styled, { createGlobalStyle } from "styled-components";

import Header from '../Components/Template/Header'
import Sidebar from '../Components/Template/Sidebar';
import QuestionList from '../Components/Mains/QuestionList'


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