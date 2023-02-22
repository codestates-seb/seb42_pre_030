import styled, { createGlobalStyle } from "styled-components";
import Questions from "../modules/Questions"


const QuestionsMain = () => {

    const Mainpage = styled.div`
    display: flex;
    width: 15vw;
    margin-left: 25vw;
    justify-content: center;
    margin-top: 0;
`

    return (
        <>
            <Mainpage>
                <Questions />
            </Mainpage>
        </>
    )

}

export default QuestionsMain