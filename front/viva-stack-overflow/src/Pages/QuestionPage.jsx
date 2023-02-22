import Questions from "../components/modules/Questions";
import Footer2 from "../components/templates/Footer2";
import Header from "../components/templates/Header/Header";
import QuestionsMain from "../components/templates/QuestionsMain";
import Main from "../components/templates/QuestionsMain";
import Sidebar from "../components/templates/Sidebar";



const QuestionPage = function () {

    return (
        <>

            <Sidebar />
            <QuestionsMain>
                <Questions />
            </QuestionsMain>
        </>
    )
}

export default QuestionPage;