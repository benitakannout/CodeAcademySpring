import {useEffect, useState} from "react";
import {getQuestionsApi} from "../../api/apiEndpoint";

const PublicQuestions = () => {
//    const {questionId} = useParams();

    const [questionObject, questionsSet] = useState([])

    useEffect(() => {
        getQuestionsApi()
            .then((response) => questionsSet(response.data))
            .catch((error) => console.log('error', error))
    }, [])

    return (<>
            {questionObject.map(questionObject => (
                <div>{questionObject.question}</div>
            ))
            }
        </>
    )
}

export default PublicQuestions;