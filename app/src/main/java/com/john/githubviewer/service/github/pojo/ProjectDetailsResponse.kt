package com.john.githubviewer.service.github.pojo

import com.google.gson.annotations.SerializedName

data class ProjectDetailsResponse(
        @SerializedName("archive_url")
        var archiveUrl: String? = null,
        @SerializedName("archived")
        var archived: Boolean? = null,
        @SerializedName("assignees_url")
        var assigneesUrl: String? = null,
        @SerializedName("blobs_url")
        var blobsUrl: String? = null,
        @SerializedName("branches_url")
        var branchesUrl: String? = null,
        @SerializedName("clone_url")
        var cloneUrl: String? = null,
        @SerializedName("collaborators_url")
        var collaboratorsUrl: String? = null,
        @SerializedName("comments_url")
        var commentsUrl: String? = null,
        @SerializedName("commits_url")
        var commitsUrl: String? = null,
        @SerializedName("compare_url")
        var compareUrl: String? = null,
        @SerializedName("contents_url")
        var contentsUrl: String? = null,
        @SerializedName("contributors_url")
        var contributorsUrl: String? = null,
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("default_branch")
        var defaultBranch: String? = null,
        @SerializedName("deployments_url")
        var deploymentsUrl: String? = null,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("downloads_url")
        var downloadsUrl: String? = null,
        @SerializedName("events_url")
        var eventsUrl: String? = null,
        @SerializedName("fork")
        var fork: Boolean? = null,
        @SerializedName("forks")
        var forks: Long? = null,
        @SerializedName("forks_count")
        var forksCount: Long? = null,
        @SerializedName("forks_url")
        var forksUrl: String? = null,
        @SerializedName("full_name")
        var fullName: String? = null,
        @SerializedName("git_commits_url")
        var gitCommitsUrl: String? = null,
        @SerializedName("git_refs_url")
        var gitRefsUrl: String? = null,
        @SerializedName("git_tags_url")
        var gitTagsUrl: String? = null,
        @SerializedName("git_url")
        var gitUrl: String? = null,
        @SerializedName("has_downloads")
        var hasDownloads: Boolean? = null,
        @SerializedName("has_issues")
        var hasIssues: Boolean? = null,
        @SerializedName("has_pages")
        var hasPages: Boolean? = null,
        @SerializedName("has_projects")
        var hasProjects: Boolean? = null,
        @SerializedName("has_wiki")
        var hasWiki: Boolean? = null,
        @SerializedName("homepage")
        var homepage: String? = null,
        @SerializedName("hooks_url")
        var hooksUrl: String? = null,
        @SerializedName("html_url")
        var htmlUrl: String? = null,
        @SerializedName("id")
        var id: Long? = null,
        @SerializedName("issue_comment_url")
        var issueCommentUrl: String? = null,
        @SerializedName("issue_events_url")
        var issueEventsUrl: String? = null,
        @SerializedName("issues_url")
        var issuesUrl: String? = null,
        @SerializedName("keys_url")
        var keysUrl: String? = null,
        @SerializedName("labels_url")
        var labelsUrl: String? = null,
        @SerializedName("language")
        var language: String? = null,
        @SerializedName("languages_url")
        var languagesUrl: String? = null,
        @SerializedName("license")
        var license: ProductLicense? = null,
        @SerializedName("merges_url")
        var mergesUrl: String? = null,
        @SerializedName("milestones_url")
        var milestonesUrl: String? = null,
        @SerializedName("mirror_url")
        var mirrorUrl: Any? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("network_count")
        var networkCount: Long? = null,
        @SerializedName("node_id")
        var nodeId: String? = null,
        @SerializedName("notifications_url")
        var notificationsUrl: String? = null,
        @SerializedName("open_issues")
        var openIssues: Long? = null,
        @SerializedName("open_issues_count")
        var openIssuesCount: Long? = null,
        @SerializedName("organization")
        var organization: ProductOrganization? = null,
        @SerializedName("owner")
        var owner: ProductOwner? = null,
        @SerializedName("private")
        var private: Boolean? = null,
        @SerializedName("pulls_url")
        var pullsUrl: String? = null,
        @SerializedName("pushed_at")
        var pushedAt: String? = null,
        @SerializedName("releases_url")
        var releasesUrl: String? = null,
        @SerializedName("size")
        var size: Long? = null,
        @SerializedName("ssh_url")
        var sshUrl: String? = null,
        @SerializedName("stargazers_count")
        var stargazersCount: Long? = null,
        @SerializedName("stargazers_url")
        var stargazersUrl: String? = null,
        @SerializedName("statuses_url")
        var statusesUrl: String? = null,
        @SerializedName("subscribers_count")
        var subscribersCount: Long? = null,
        @SerializedName("subscribers_url")
        var subscribersUrl: String? = null,
        @SerializedName("subscription_url")
        var subscriptionUrl: String? = null,
        @SerializedName("svn_url")
        var svnUrl: String? = null,
        @SerializedName("tags_url")
        var tagsUrl: String? = null,
        @SerializedName("teams_url")
        var teamsUrl: String? = null,
        @SerializedName("trees_url")
        var treesUrl: String? = null,
        @SerializedName("updated_at")
        var updatedAt: String? = null,
        @SerializedName("url")
        var url: String? = null,
        @SerializedName("watchers")
        var watchers: Long? = null,
        @SerializedName("watchers_count")
        var watchersCount: Long? = null
)