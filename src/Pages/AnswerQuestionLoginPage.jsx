import styled, { createGlobalStyle } from "styled-components";

import Header from '../components/template/Header'
import Sidebar from '../components/template/Sidebar';
import AnswerQuestion from '../components/main/AnswerQuestion'


const AnswerQuestionLoginPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 840px;
    
`

    return (
        <>
            <Header />
            <MainBar>
                <Sidebar />
                <AnswerQuestion />
            </MainBar>
        </>
    )
}

export default AnswerQuestionLoginPage;
