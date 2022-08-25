import {useEffect, useState} from "react";
import {getForumApi} from "../../api/apiEndpoint";

const ForumPage = () => {

    const [forumObject, forumSet] = useState([])

    useEffect(() => {
        getForumApi()
            .then((response) => forumSet(response.data))
            .catch((error) => console.log('error', error))
    }, [])

    return (<>
            {forumObject.map(forumObject => (
                <div>{forumObject.question}</div>
            ))
            }
        </>
    )
}

export default ForumPage;