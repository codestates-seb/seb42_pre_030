import { Link } from "react-router-dom";
import styled, { createGlobalStyle } from "styled-components";

const QuestionList = function () {

    const BigTitle = styled.div`
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
        width: 100%;
    `

    const TopQuestions = styled.h1`
        font-size: 28px;
        font-weight: 400;
        margin-left: 20px;
    `

    const AskButton = styled.button`
        background-color: #0a95ff;
        border: 1px solid #0a95ff;
        border-radius: 4px;
        box-shadow: inset 0 1px 0 0 #6fc0ff;
        color: white;
        height: 35px;
        margin: auto 0;
        width: 100px;

        &:hover {
            background-color: #306fa0;
            border: 1px solid #306fa0;
            box-shadow: inset 0 1px 0 0 #65869e;
            color: #aeaeae;
            cursor: pointer;
    }
    `

    return (
        <BigTitle>
            <TopQuestions>Top Questions</TopQuestions>
            <Link to={'/questionsubmit'}>
                <AskButton>Ask Question</AskButton>
            </Link>
        </BigTitle>
    )
}

export default QuestionList;