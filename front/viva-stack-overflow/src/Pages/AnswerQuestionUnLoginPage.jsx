import styled, { createGlobalStyle } from "styled-components";

import Sidebar from '../Components/Template/Sidebar';
import AnswerQuestion from '../Components/Mains/AnswerQuestion'
import HeaderWithLogin from "../Components/Template/HeaderWithLogin";


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