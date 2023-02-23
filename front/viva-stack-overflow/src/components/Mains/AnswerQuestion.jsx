import styled, { createGlobalStyle } from "styled-components";
import QuestionZone from "../Modules/AnswerQuestion/QuestionZone";
import QuestionHeader from "../Modules/AnswerQuestion/QuestionHeader";
import AnswerForm from "../Modules/AnswerQuestion/AnswerForm";
import AnswerZone from "../Modules/AnswerQuestion/AnswerZone";


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