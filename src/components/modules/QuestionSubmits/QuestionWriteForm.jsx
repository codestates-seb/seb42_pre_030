import styled from "styled-components";
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const QuestionWriteForM = styled.div`
margin-top: 24px;
padding: 24px;
border: 1px solid lightgrey;
border-radius: 5px;
`

const PostTitleBox = styled.div`
margin-top: 24px;
padding: 24px;
border: 1px solid lightgrey;
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

const QuestionSubmitBtn = styled.button`
background-color: rgb(10, 149, 255);
color: rgb(255, 255, 255);
width: 850px;
height: 60px;
margin: 20px;
border-radius: 10px;
border: 1px solid aliceblue ;
&:hover {
    background-color: rgb(49, 114, 198);
}
`

const QuestionWriteForm = function () {



    const navigate = useNavigate();
    const [data, setData] = useState({
        title: '',
        content: '',
    });


    const token = localStorage.getItem('token');

    const header = {
        headers: {
            'Content-Type': `application/json`,
            'authorization': `Bearer ${token}`,
        },
    };


    const onChange = (event) => {
        const { name, value } = event.target;
        setData((prev) => ({
            ...prev,
            [name]: value,
        }));
    };
    const onSubmit = (event) => {
        event.preventDefault();
        console.log(data);
        axios
            .post(
                'http://ec2-3-35-220-165.ap-northeast-2.compute.amazonaws.com:8080/questions',
                data,
                header,
            )
            .then(() => {
                alert(`Successfully posted!`);
                navigate('/questions');
            })
            .catch((err) => console.log(`${err}`));
    };


    return (
        <>
            <form className="submit-form" onChange={onChange} action="" onSubmit={onSubmit}>

                <div className="question-title">
                    <PostTitleBox>
                        <h4>Title</h4>
                        <p>Be specific and imagine you're asking a question to another person.</p>
                        <TitleInput type='ㅅㄷㅌㅅ' name="title" placeholder="Write Here" />
                    </PostTitleBox>
                </div>

                <QuestionWriteForM>
                    <div className="questionWrite">
                        <div className="writeBox">
                            <div className="titles">
                                <h4 className="WriteTitle">What are the details of your problem?</h4>
                                <p className="WriteTitleInfo">Introduce the problem and expand on what you put in the title.</p>
                                <WriteForm type="text" name="content" placeholder="Write Here"></WriteForm>
                            </div>
                            <div className="forms"></div>
                        </div>
                    </div>
                </QuestionWriteForM>

                <QuestionSubmitBtn type="submit">Submit</QuestionSubmitBtn>

            </form>
        </>
    )
}

export default QuestionWriteForm;