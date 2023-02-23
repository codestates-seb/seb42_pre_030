import styled, { createGlobalStyle } from "styled-components";
import Footer from "../Components/Template/Footer";
import Header from "../Components/Template/Header";
import Sidebar from "../Components/Template/Sidebar";
import QuestionSubmit from '../Components/Mains/QuestionSubmit'


const QuestionSubmitPage = function () {

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
                <QuestionSubmit />
            </MainBar>
            <Footer />
        </>
    )
}

export default QuestionSubmitPage;