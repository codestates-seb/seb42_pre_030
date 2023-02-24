import styled from "styled-components"


const QuestionNoticeBox = function () {

    const QuestionNoticeBox = styled.div`
`

    const QuestionNotice = styled.div`
    margin-top: 30px;
    padding: 24px;
    background-color: #E1ECF4;
    border-radius: 5px;
    width: 850px;
    border: 1px solid lightblue;
`

    return (
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
    )
}

export default QuestionNoticeBox;