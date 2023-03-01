import styled, { createGlobalStyle } from "styled-components";



const QuestionZone = function () {

    const PostLayout = styled.div`
    display: flex;
    flex-direction: row;
    width: 900px;
    padding-bottom: 24px;
    margin-top: 20px
    `

    const QuestionContent = styled.div`
    display: flex;
    align-items: center;
    flex-direction:column;
    margin-left: 20px;
    `

    const VoteIcon = styled.button`
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
    width: 20px;
    height: 20px;
    margin: 8px;
    `

    const EditBtn = styled.div`
        background-color: rgb(225, 236, 244);
        box-shadow: inset 0px 1px 0px 0px rgba(255, 255, 255, 0.3);
        border: 1px solid rgb(57, 115, 157);
        border-radius: 3px;
        color: rgb(57, 115, 157);
        font-size: 14px;
        font-weight: 400;
        text-align: center;
        margin-top: 30px;
        width: 840px;
        &:hover {
            background-color: rgb(185, 210, 232);
        }
        `

    return (
        <PostLayout>
            <div className="voting-container">
                <VoteIcon>^</VoteIcon>
                <div className="vote-count">157</div>
                <VoteIcon>_</VoteIcon>
            </div>
            <QuestionContent>
                <div question-content-item>
                    However, the meaning of the command is not clear to me. Why does it have this effect?
                    I haven't been able to find an answer (this question seems to treat the problem, but the title is misleading).
                </div>
                <EditBtn>Edit</EditBtn>
            </QuestionContent>
        </PostLayout>
    )
}

export default QuestionZone;