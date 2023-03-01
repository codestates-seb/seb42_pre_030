import styled, { createGlobalStyle } from "styled-components";
import axios from 'axios';
import { useEffect } from "react";


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

const Questions = function () {



    useEffect(() => {

        const handleData = async () => {
            try {
                const response = await axios.get('http://ec2-3-35-220-165.ap-northeast-2.compute.amazonaws.com:8080/questions?page=1&size=10', config)
                const { data } = response
                console.log(data);
            } catch (error) {
                console.log(error)
            }
        }
        handleData()
    }, [])




    return (
        <>
            <div className='q-post-summary-stats'>
                <div className='votes'>0 votes</div>
                <div className='answers'>0 answers</div>
                <div className='views'>0 views</div>
            </div>
            <div className='q-post-summary-content'>
                <Qtitle><a href="" >제목입니다만</a></Qtitle>
                <Qmeta>Jens 66.5k modified 16secs ago</Qmeta>
            </div>
        </>
    )





}

export default Questions;