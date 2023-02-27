import styled, { createGlobalStyle } from "styled-components";
import axios from 'axios';
import { useEffect } from "react";


const Questions = function () {


    const Qtitle = styled.h3`
        display: flex;
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
        margin-top: 7px;
        width: 100%;
    `

    const config = {
        headers: {
            "content-type": "application/json",
        },
    };

    useEffect(() => {

        const handleData = async () => {
            try {
                const response = await axios.get('https://3c2b-39-121-143-132.jp.ngrok.io/questions/1', config)
                const { data } = response
                console.log(data);
            } catch (error) {
                console.log(error)
            }
            handleData()
        }
    }, [])


    const Click = function () {
        console.log('data')
    }



    return (
        <>
            <div className='q-post-summary-stats'>
                <div className='votes'>0 votes</div>
                <div className='answers'>0 answers</div>
                <div className='views'>0 views</div>
            </div>
            <div className='q-post-summary-content'>
                <Qtitle><a onClick={Click} href="" >제목입니다만</a></Qtitle>
                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
            </div>
        </>
    )





}

export default Questions;