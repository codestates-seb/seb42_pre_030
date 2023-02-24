import styled, { createGlobalStyle } from "styled-components";
import Sidebar from "../components/template/Sidebar";
import QuestionSubmit from '../components/main/QuestionSubmit'
import HeaderWithLogin from "../components/template/HeaderWithLogin";


const QuestionSubmitPage = function () {

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
                <QuestionSubmit />
            </MainBar>
        </>
    )
}

export default QuestionSubmitPage;