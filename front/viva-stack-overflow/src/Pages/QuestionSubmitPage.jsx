import styled, { createGlobalStyle } from "styled-components";
import Sidebar from "../Components/Template/Sidebar";
import QuestionSubmit from '../Components/Mains/QuestionSubmit'
import HeaderWithLogin from "../Components/Template/HeaderWithLogin";


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