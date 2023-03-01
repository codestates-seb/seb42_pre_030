import styled, { createGlobalStyle } from "styled-components";


const AnswerForm = function () {

    const AnswerLayout = styled.div`
    margin: 10px;
    width: 900px;
    padding: 30px;
        `

    const TextForm = styled.textarea`
        width: 910px;
        height: 100px;
        margin: 0;
        `

    const Button = styled.button`
        all: unset;
        background-color: rgb(225, 236, 244);
        box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.3);
        border: 1px solid rgb(57, 115, 157);
        border-radius: 3px;
        color: rgb(57, 115, 157);
        font-size: 14px;
        font-weight: 400;
        text-align: center;
        &:hover {
            background-color: rgb(185, 210, 232);
        }
        margin-top: 20px;
        padding: 5px;
`

    return (
        <AnswerLayout>
            <h4>Your Answer</h4>
            <TextForm className="write-form" placeholder="Write Here"></TextForm>
            <Button>SUBMIT</Button>
        </AnswerLayout>
    )
}

export default AnswerForm;
