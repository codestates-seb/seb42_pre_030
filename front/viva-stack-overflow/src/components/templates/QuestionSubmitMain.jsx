import styled, { createGlobalStyle } from "styled-components";
import QuestionSubmit from "../modules/QuestionSubmit";



const QuestionSubmitMain = () => {

    const Mainpage = styled.div`
    display: flex;
    margin-left: 15vw;
    
    justify-content: center;
    margin-top: 0;
`

    return (
        <>
            <Mainpage>
                <QuestionSubmit />
            </Mainpage>
        </>
    )

}

export default QuestionSubmitMain