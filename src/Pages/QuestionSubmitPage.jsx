import styled, { createGlobalStyle } from "styled-components";
import Sidebar from "../components/template/Sidebar";
import QuestionSubmit from '../components/main/QuestionSubmit'
import HeaderWithLogin from "../components/template/HeaderWithLogin";


const QuestionSubmitPage = function () {

    const MainBar = styled.div`
    display: flex;
    justify-content: center;
    
    
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