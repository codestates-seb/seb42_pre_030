import styled, { createGlobalStyle } from "styled-components";

import Questions from './Questions'

const QListWrapper = function () {


    const QlistsWrapper = styled.div`
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


    const Qsummary = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-bottom: 30px;
    width: 900px;
    `

    return (
        <QlistsWrapper>
            <QminiList>

                <Qsummary>
                    <Questions />
                </Qsummary>

            </QminiList>
        </QlistsWrapper>
    )
}

export default QListWrapper;