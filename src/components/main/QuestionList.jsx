import styled, { createGlobalStyle } from "styled-components";
// import BigTitle from '../Modules/QuestionList/BigTitle'
// import QListWrapper from '../Modules/QuestionList/QListWrapper'

import BigTitle from '../modules/QuestionLists/BigTitle'
import QListWrapper from '../modules/QuestionLists/QListWrapper'


const QuestionsMain = () => {

    const Mainpage = styled.div`
    display: flex;
    flex-direction: column;
    width: 60vw;
    justify-content: center;
    margin-top: 0;
`

    return (
        <>
            <Mainpage>
                <BigTitle />
                <QListWrapper />
                <QListWrapper />
                <QListWrapper />
                <QListWrapper />
                <QListWrapper />
                <QListWrapper />
                <QListWrapper />
            </Mainpage>
        </>
    )

}

export default QuestionsMain