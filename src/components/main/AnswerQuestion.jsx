import styled, { createGlobalStyle } from "styled-components";
// import QuestionZone from "../modules/answerQuestion/questionZone";
// import QuestionHeader from "../modules/answerQuestion/questionHeader";
// import AnswerForm from "../modules/answerQuestion/answerForm";
// import AnswerZone from "../modules/answerQuestion/answerZone";

import QuestionZone from '../modules/AnswerQuestions/QuestionZone'
import QuestionHeader from '../modules/AnswerQuestions/QuestionHeader'
import AnswerForm from '../modules/AnswerQuestions/AnswerForm'
import AnswerZone from '../modules/AnswerQuestions/AnswerZone'

const AnswerSubmitMain = () => {

    const Mainpage = styled.div`
    display: flex;
    flex-direction: column;
    margin-left: 15vw;
    
    justify-content: center;
    margin-top: 0;
    margin-left: 0;
    margin-bottom: 100px;
`

    const Line = styled.div`
    margin-left: 8vw;
    height: 3px;
    width: 840px;
    margin-top: 40px;
    margin-bottom: 40px;
    background-color: aliceblue;
    `

    return (
        <>
            <Mainpage>
                <QuestionHeader />
                <QuestionZone />
                <Line />
                <AnswerZone />
                <AnswerForm />
            </Mainpage>
        </>
    )

}

export default AnswerSubmitMain