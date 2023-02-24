import styled, { createGlobalStyle } from "styled-components";

const QuestionWriteForm = function () {

    const QuestionWriteForm = styled.div`
  margin-top: 24px;
    padding: 24px;
    border: 1px solid lightgray;
    border-radius: 5px;
`

    const PostTitleBox = styled.div`
margin-top: 24px;
padding: 24px;
border: 1px solid lightgray;
border-radius: 5px;
`

    const TitleInput = styled.input`
height: 25px;
width: 840px;
`

    const WriteForm = styled.textarea`
height: 50vh;
width: 840px;
`

    return (
        <>
            <div className="question-title">
                <PostTitleBox>
                    <h4>Title</h4>
                    <p>Be specific and imagine you're asking a question to another person.</p>
                    <TitleInput placeholder="Write Here" />
                </PostTitleBox>
            </div>
            <QuestionWriteForm>
                <div className="questionWrite">
                    <div className="writeBox">
                        <div className="titles">
                            <h4 className="WriteTitle">What are the details of your problem?</h4>
                            <p className="WriteTitleInfo">Introduce the problem and expand on what you put in the title.</p>
                            <WriteForm placeholder="Write Here"></WriteForm>
                        </div>
                        <div className="forms"></div>
                    </div>
                </div>
            </QuestionWriteForm>
        </>
    )
}

export default QuestionWriteForm;