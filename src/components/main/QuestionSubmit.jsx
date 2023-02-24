import styled, { createGlobalStyle } from "styled-components";
// import QuestionSubmitBtn from "../Modules/QuuestionSubmit/QuestionSubmitBtn";
// import QuestionNoticeBox from "../Modules/QuuestionSubmit/QuestionNoticeBox";
// import QuuestionWrite from "../Modules/QuuestionSubmit/QuestionWriteForm"

import QuestionSubmitBtn from '../modules/QuestionSubmits/QuestionSubmitBtn'
import QuestionNoticeBox from '../modules/QuestionSubmits/QuestionNoticeBox'
import QuestionWrite from '../modules/QuestionSubmits/QuestionWriteForm'

const QuestionSubmitMain = () => {

    const QuestionSubmit = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-top: 0;
    padding: 40px;
    width: 900px;
`

    return (
        <QuestionSubmit>
            <QuestionNoticeBox />
            <QuestionWrite />
            <QuestionSubmitBtn />
        </QuestionSubmit>
    )

}

export default QuestionSubmitMain;