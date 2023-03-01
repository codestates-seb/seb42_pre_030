import styled, { createGlobalStyle } from "styled-components";
// import QuestionSubmitBtn from "../Modules/QuuestionSubmit/QuestionSubmitBtn";
// import QuestionNoticeBox from "../Modules/QuuestionSubmit/QuestionNoticeBox";
// import QuuestionWrite from "../Modules/QuuestionSubmit/QuestionWriteForm"

import QuestionNoticeBox from '../modules/QuestionSubmits/QuestionNoticeBox'
import QuestionWrite from '../modules/QuestionSubmits/QuestionWriteForm'

const QuestionSubmitMain = () => {

    const QuestionSubmit = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 0;
    padding: 24px;
    border-left:1px solid rgb(181, 181, 181);
`

    return (
        <QuestionSubmit>
            <QuestionNoticeBox />
            <QuestionWrite />
        </QuestionSubmit>
    )

}

export default QuestionSubmitMain;