import styled, { createGlobalStyle } from "styled-components";

const QuestionSubmitBtn = function () {

    const QuestionSubmitBtn = styled.button`
        background-color: rgb(10, 149, 255);
        color: rgb(255, 255, 255);
        width: auto;
        height: 32px;
        margin: 20px;
        border-radius: 10px;
        border: 1px solid aliceblue ;
        &:hover {
            background-color: rgb(49, 114, 198);
        }
        `

    return (
        <>
            <QuestionSubmitBtn>Submit</QuestionSubmitBtn>
        </>
    )
}

export default QuestionSubmitBtn;