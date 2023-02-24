import styled, { createGlobalStyle } from "styled-components";

import Sidebar from '../components/template/Sidebar';
import AnswerQuestion from '../components/main/AnswerQuestion'
import HeaderWithLogin from "../components/template/HeaderWithLogin";


const AnswerQuestionUnLoginPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 840px;
    
`

    return (
        <>
            <HeaderWithLogin />
            <MainBar>
                <Sidebar />
                <AnswerQuestion />
            </MainBar>
        </>
    )
}

export default AnswerQuestionUnLoginPage;