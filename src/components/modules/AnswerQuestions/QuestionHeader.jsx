import styled, { createGlobalStyle } from "styled-components";



const QuestionHeader = function () {

    const QHeader = styled.div`
    width: 900px;
    padding-bottom: 24px;
    margin-top: 50px
    `

    return (
        <QHeader>
            <h2 className="question-title">문제가 발생했다.</h2>
            <div className="question-meta">
                <span className="question-meta-item">Asked 8 years, 10 months ago</span>
                <span className="question-meta-item">Modified 2years, 2months ago</span>
                <span className="question-meta-item">Viewed 175k times</span>
            </div>
        </QHeader>
    )

}

export default QuestionHeader;
