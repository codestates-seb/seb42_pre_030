import styled, { createGlobalStyle } from "styled-components";


const Question = function () {


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

    return (
        <>

            <div className='q-post-summary-stats'>
                <div className='votes'>0 votes</div>
                <div className='answers'>0 answers</div>
                <div className='views'>0 views</div>
            </div>
            <div className='q-post-summary-content'>
                <Qtitle><a href="">제목입니다만</a></Qtitle>
                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
            </div>


        </>
    )
}

export default Question;
