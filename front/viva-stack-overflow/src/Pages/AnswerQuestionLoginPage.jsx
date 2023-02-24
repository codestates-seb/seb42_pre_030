import styled, { createGlobalStyle } from "styled-components";

import Header from '../Components/Template/Header'
import Sidebar from '../Components/Template/Sidebar';
import AnswerQuestion from '../Components/Mains/AnswerQuestion'


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
