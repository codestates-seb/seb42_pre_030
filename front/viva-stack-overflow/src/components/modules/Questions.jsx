import styled, { createGlobalStyle } from "styled-components";
import { useNavigate } from "react-router-dom";


const Questions = function () {

    const Mainbar = styled.div`
        display: flex;
        flex-direction: column;
        margin: 0;
        padding: 0;
    `

    const BigTitle = styled.div`
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
        width: 100%;
    `

    const TopQuestions = styled.h1`
        font-size: 28px;
        font-weight: 400;
        margin-left: 20px;
    `

    const AskButton = styled.button`
        background-color: #0a95ff;
        border: 1px solid #0a95ff;
        border-radius: 4px;
        box-shadow: inset 0 1px 0 0 #6fc0ff;
        color: white;
        height: 35px;
        margin: auto 0;
        width: 100px;

        &:hover {
            background-color: #306fa0;
            border: 1px solid #306fa0;
            box-shadow: inset 0 1px 0 0 #65869e;
            color: #aeaeae;
            cursor: pointer;
    }
    `

    const QlistWrapper = styled.div`
        border: 1px solid #c5c5c5;
        border-width: ${(props) => (props.isLast ? "1px 0 1px 0" : "1px 0 0 0")};
        display: flex;
        float: right;
        height: max-content;
        max-width: 900px;
        padding: 16px;
    `

    const QminiList = styled.div`
        color: ${(props) => (props.isVote ? `black` : `gray`)};
        font-size: 13px;
        margin: 0;
        margin-bottom: 8px;
    `

    const Qtitle = styled.h3`
        display: flex;
        flex-direction: row-reverse;
        color: #0074cc;
        font-size: large;
        font-weight: 500;
        &:hover {
        color: #49a5f0;
        cursor: pointer;
        }
    `

    const Qmeta = styled.div`
        display: flex;
        justify-content: space-between;
        justify-items: stretch;
        margin-top: 7px;
        width: 100%;
    `

    const Qsummary = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 30px;
    width: 60vw;
    `



    return (
        <>
            <Mainbar>
                <BigTitle>
                    <TopQuestions>Top Questions</TopQuestions>
                    <AskButton>
                        <a href='/questions/ask' className="q-btn-link"></a>
                        Ask Question
                    </AskButton>
                </BigTitle>
                <QlistWrapper>
                    <QminiList>

                        <Qsummary>
                            <div className='q-post-summary-stats'>
                                <div className='votes'>0 votes</div>
                                <div className='answers'>0 answers</div>
                                <div className='views'>0 views</div>
                            </div>
                            <div className='q-post-summary-content'>
                                <Qtitle>
                                    <a href="">제목입니다만</a></Qtitle>
                                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
                            </div>
                        </Qsummary>
                        <Qsummary>
                            <div className='q-post-summary-stats'>
                                <div className='votes'>0 votes</div>
                                <div className='answers'>0 answers</div>
                                <div className='views'>0 views</div>
                            </div>
                            <div className='q-post-summary-content'>
                                <Qtitle>
                                    <a href="">제목입니다만</a></Qtitle>
                                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
                            </div>
                        </Qsummary>
                        <Qsummary>
                            <div className='q-post-summary-stats'>
                                <div className='votes'>0 votes</div>
                                <div className='answers'>0 answers</div>
                                <div className='views'>0 views</div>
                            </div>
                            <div className='q-post-summary-content'>
                                <Qtitle>
                                    <a href="">제목입니다만</a></Qtitle>
                                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
                            </div>
                        </Qsummary>
                        <Qsummary>
                            <div className='q-post-summary-stats'>
                                <div className='votes'>0 votes</div>
                                <div className='answers'>0 answers</div>
                                <div className='views'>0 views</div>
                            </div>
                            <div className='q-post-summary-content'>
                                <Qtitle>
                                    <a href="">제목입니다만</a></Qtitle>
                                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
                            </div>
                        </Qsummary>
                        <Qsummary>
                            <div className='q-post-summary-stats'>
                                <div className='votes'>0 votes</div>
                                <div className='answers'>0 answers</div>
                                <div className='views'>0 views</div>
                            </div>
                            <div className='q-post-summary-content'>
                                <Qtitle>
                                    <a href="">제목입니다만</a></Qtitle>
                                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
                            </div>
                        </Qsummary>

                    </QminiList>
                </QlistWrapper>
            </Mainbar>
        </>
    )
}

export default Questions;