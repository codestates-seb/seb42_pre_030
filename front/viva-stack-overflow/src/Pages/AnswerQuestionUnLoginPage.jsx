import styled, { createGlobalStyle } from "styled-components";

import HeaderLogin from '../Components/Template/HeaderLogin'
import Sidebar from '../Components/Template/Sidebar';
import AnswerQuestion from '../Components/Mains/AnswerQuestion'


const AnswerQuestionUnLoginPage = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 840px;
    
`

    return (
        <>
            <HeaderLogin />
            <MainBar>
                <Sidebar />
                <AnswerQuestion />
            </MainBar>
        </>
    )
}

export default AnswerQuestionUnLoginPage;