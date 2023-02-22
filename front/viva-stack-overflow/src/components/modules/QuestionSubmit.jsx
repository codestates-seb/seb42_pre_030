import styled from "styled-components";


const QuestionSubmit = function () {

    const QuestionFormContainer = styled.div`
    
    `

    const QuestionNoticeBox = styled.div`
    margin-top: 10vh;
`

    const QuestionNotice = styled.div`
    margin-top: 30px;
    padding: 24px;
    background-color: #E1ECF4;
    border-radius: 5px;
    border: 1px solid lightblue;
`

    const QuestionTitle = styled.div`

`

    const QuestionWriteForm = styled.div`
  margin-top: 24px;
    padding: 24px;
    border: 1px solid lightgray;
    border-radius: 5px;
`

    const QuestionSubmitButton = styled.button`
        background-color: rgb(10, 149, 255);
        color: rgb(255, 255, 255);
        width: 65px;
        height: 32px;
        margin: 20px;
        &:hover {
            background-color: rgb(49, 114, 198);
        }
`

    const PostTitleBox = styled.div`
    margin-top: 24px;
    padding: 24px;
    border: 1px solid lightgray;
    border-radius: 5px;
    
    
    `

    const PostTitle = styled.h4`
`

    const PostTitleInfo = styled.p`

`

    const TitleInput = styled.input`
    width: 68vw;
    height: 25px;
`

    const WriteForm = styled.textarea`
    width: 68vw;
    height: 50vh;
`


    return (
        <>
            <QuestionFormContainer>
                <QuestionNoticeBox>
                    <h1 className="AskTitle">Ask a public question</h1>
                    <QuestionNotice>
                        <h2 className="NoticeTitle">Writing a good question</h2>
                        <p className="NoticeOne">You’re ready to ask a programming-related question and this form will help guide you through the process.</p>
                        <p className="NoticeTwo">Looking to ask a non-programming question? See the topics here to find a relevant site.</p>
                        <h5 className="Notice Title2"></h5>
                        <ul className="NoticeUl"> Steps
                            <li className="NoticeLi">Summarize your broblem in a one-line title.</li>
                            <li className="NoticeLi">Describe your problem in more detail.</li>
                            <li className="NoticeLi">Describe what you tried and what you expected to happen.</li>
                            <li className="NoticeLi">Add "tags" which help surface your question to members of the community</li>
                            <li className="NoticeLi">Review your question and post it to the site.</li>
                        </ul>
                    </QuestionNotice>
                </QuestionNoticeBox>
                <QuestionTitle><PostTitleBox>
                    <PostTitle>Title</PostTitle>
                    <PostTitleInfo>Be specific and imagine you're asking a question to another person.</PostTitleInfo>
                    <TitleInput placeholder="Write Here" />
                </PostTitleBox></QuestionTitle>
                <QuestionWriteForm><div className="questionWrite">
                    <div className="writeBox">
                        <div className="titles">
                            <h4 className="WriteTitle">What are the details of your problem?</h4>
                            <p className="WriteTitleInfo">Introduce the problem and expand on what you put in the title.</p>
                            <WriteForm placeholder="Write Here"></WriteForm>
                        </div>
                        <div className="forms"></div>
                    </div>
                </div></QuestionWriteForm>
                <QuestionSubmitButton>Submit</QuestionSubmitButton>
            </QuestionFormContainer>
        </>
    )
}

export default QuestionSubmit;